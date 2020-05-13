package com.batch.app.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.annotation.OnReadError;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.batch.app.model.Employee;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Bean
	public Job job1(JobBuilderFactory builderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<Employee> itemReader, ItemProcessor<Employee, Employee> itemProcessor,
			ItemWriter<Employee> itemWriter) {
		Step step = stepBuilderFactory.get("step1").<Employee, Employee>chunk(50).reader(itemReader)
				.processor(itemProcessor).writer(itemWriter).faultTolerant().skipLimit(3)
				.skip(FlatFileParseException.class).build();
		return builderFactory.get("testJob").incrementer(new RunIdIncrementer()).start(step).build();
	}

	@Bean
	public FlatFileItemReader<Employee> itemReader(@Value(value = "${input}") Resource resource) {
		return new FlatFileItemReaderBuilder<Employee>().name("itemReader1").resource(resource)
				.targetType(Employee.class).delimited().delimiter(",")
				.names(new String[] { "id", "employeeName", "designation", "createdTS", "modifiedTS" }).build();
	}

	@Bean
	public LineMapper<Employee> lineMapper() {
		// TODO Auto-generated method stub
		DefaultLineMapper<Employee> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setStrict(false);
		delimitedLineTokenizer.setDelimiter(",");
		delimitedLineTokenizer
				.setNames(new String[] { "id", "employeeName", "designation", "createdTS", "modifiedTS" });
		defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
		BeanWrapperFieldSetMapper<Employee> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
		defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

		return defaultLineMapper;
	}

	@OnReadError
	public void onReadError(Exception ex) {
		if (ex instanceof FlatFileParseException) {
			FlatFileParseException ffpe = (FlatFileParseException) ex;
			System.out.println("Error reading data on line " + ffpe.getLineNumber() + "  data:" + ffpe.getInput());
		}
	}
}
