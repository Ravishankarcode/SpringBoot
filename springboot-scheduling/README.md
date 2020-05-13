# SpringBoot Scheduling

## Scheduling Using Crone

First use `@EnableScheduling` annotation of Configuration class
 
```
@Scheduled(cron = "0 0 6 * * ?")
```

Use this refrence for more details.


## Scheduling Using `fixedRate`
If a fixed rate execution is desired, simply change the property name specified within the annotation.
The following would be executed every 5 seconds measured between the successive start times of each invocation.
	
```
@Scheduled(fixedRate = 5000)
```

## Scheduling Using `initialDelay` and `fixedRate`

For fixed-delay and fixed-rate tasks, an initial delay may be specified indicating the number of milliseconds to wait before the first execution of the method.

```
@Scheduled(initialDelay=1000, fixedRate=5000)
```

## Scheduling Using  `fixedDelay`

The @Scheduled annotation can be added to a method along with trigger metadata.The following method would be invoked every 5 seconds with a fixed delay, meaning that the period will be measured from the completion time of each preceding invocation.
	
```
@Scheduled(fixedDelay=5000)
```


                                ===========================================================

