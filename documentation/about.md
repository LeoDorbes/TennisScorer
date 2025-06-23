# About this exercise :

Regarding this kata, I chose to use Spring boot instead of a plain java project to display some of the patterns I like to follow in Spring Boot. 

This project was booted using Spring Initializr https://start.spring.io/.

The Game Service can be used as a standalone component, outside Spring Boot, with very few changes.

An example Main method is available to show that.

# Kata context :

Given the context of the exercise, I was lacking informations about the expected result.

If I could ask a product owner, I would have asked for :
 
* The specific display expected for every combination
  * more details on the "Deuce" display
  * more details on the "Advantage" display

to make sure that it would fit the requirements.

I tried to follow the following principles for this exercise :

* DRY : Least amount of code repetition
* Spring architecture and use of stereotypes, as much as possible
* Unit testing of everything
* Keep only the necessary data, no duplicate, that is why I keep the score as a simple pair of integers and "interpret" it on console log when print is required


I chose not to follow the following patterns to avoid over-engineering
<em>(even though, I must admin that the code is already a little over-engineered, but it's the point of the exercise)</em> :

* Hexagonal Architecture (no use of interfaces)
* RESTful endpoint
* Spring config
* DTOs (not necessary in the context)

The rest of spring-boot's ecosystem is simply way too overkill for this simple kata.

Thank you for reading :)

Léo
