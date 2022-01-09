## Table of contents
* [Tempo-Coding-Challenge](#tempo-coding-challenge)
* [Approach](#approach)
* [API-Changes](#api-changes)
* [Technologies](#technologies)
* [Setup](#setup)

## Tempo-Coding-Challenge
This project is a back-end exercise, the coding challenge that I've received.

## Approach
Since in the coding challenge document there were functional APIs and the requested increments were some new functionalities involving the existing entities in the aforementioned APIs, I decided to make this project like an extension of the project that contains the User and Team APIs. 
I created what was requested and, to make it as real as possible, I used the APIs provided as a kind of database, only accepting teams or users that exists in the APIs.

## API-Changes
If I could ask changes in the Team and User APIs, that would be:
* Both APIs: Possibility to check the existence of a given id, without receiving the entire objects json
* Team API: Possibility to check if a team contains a user of a given id, without the need to deal with the entire list
* Both APIs: To have pagination in the listing endpoints (Its not a big deal when talking about this coding challenge, but its a performance point that worth mentioning)

## Technologies
Project is created with:
* Java: 1.8
* Spring Boot: 2.6.2
* H2 Database
* springdoc-openapi library: 1.6.4
* Docker 20.10.5, build 55c4c88
	
## Setup
To run this project, you need to have docker installed and working

```
$ clone the project or download the zip and extract it
$ cd ./challenge (Open in CMD or terminal the directory that you have cloned the project)
$ docker-compose up (Run the project with docker)
```
* After the project start, he will be available at http://localhost:8080/challenge
* P.S: You can have an idea about how the APIs are waiting the requests accessing: http://localhost:8080/challenge/api-documentation
