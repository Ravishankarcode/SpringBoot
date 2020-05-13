# SpringBoot Properties Reading

Three way to reading application.properties file in SpringBoot

## 1. Using Environment Object

```
@Autowired
private Environment env;

env.getProperty(key);
```

## 2. Using `@Value` annotation

```
@Value("${key}")
private String appTitle;
```

## 3. Using `@ConfigurationProperties` annotaion

First Create a Component Class and add getter and setter method of all keys.
Then fetch using below.

```
	@Autowired
	AppProperties myAppProperties;
  
  myAppProperties.getTitle()
```

