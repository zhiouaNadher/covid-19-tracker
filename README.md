
##  Covid-19-tracker

 Spring boot project for covid19

- Create a REST API app to expose service which can
- Bulk add/modify daily/monthly cases of covid (with patient details like test date, test result, name, DOB and address)
- Bulk add/modify daily/monthly covid vaccination info(with patient details like vaccination date, second vaccination date, name, DOB and address)
- Get report of the total number of cases per day,per month, per year for every country (atleast have three countries) with pagination support

## Requirements

For building and running the application you need:
- JDK 1.8
- Maven 3

## Technology Stack

Overview

| Technology            | Description      
| :-------------------- | :---------------------  
| `Core Framework	`   | `Spring Boot2` 
| `Persistent Layer Framework	`   | `Spring Data JPA`  
| `Database	`   | `MySQL`  

Data

| Technology            | Description      
| :-------------------- | :---------------------  
| `MySQL	`   | `Open-Source Relational Database Management System` 
| `H2 Database Engine`   | `Java SQL database. Embedded and server modes; in-memory databases`  
 

 Libraries and Plugins

| Technology            | Description      
| :-------------------- | :---------------------  
| `Lombok	`   | `	Never write another getter or equals method again.` 

Others

| Technology            | Description      
| :-------------------- | :---------------------  
| `	git		`   | `Free and Open-Source distributed version control system.` 
| `	Postman		`   | `API Development Environment (Testing web service).` 

## DataBase

The application uses H2 database (data in memory).  

URL to access H2 console: http://localhost:8080/h2-console/login.jsp

Fill the login form as follows and click on Connect:

- Saved Settings: Generic H2 (Embedded)
- Setting Name: Generic H2 (Embedded)
- Driver class: org.h2.Driver
- JDBC URL: jdbc:h2:mem:testdb
- User Name: sa
- Password:



## API Reference
Base URI : http://localhost:8080
### Cases covid 

#### Get all cases

```http
  GET /api/covid-cases/list
```
#### Add Test

```http
  POST api/covid-cases/create
  Application Type JSON 

  { 	
      "patientFullName":"Nadher",
	  "patientAdress": "Nabeul 8080" ,
	  "patientCountry":"TUNISIA",
	  "patientBirthdate":"1990-01-01",
	  "covidTestResult":"NEGATIVE"
  }
```
NB : If the patient does not exist, we create a new patient
#### Update Test

```http
  POST api/covid-cases/update/{id}
  Application Type JSON 

  { 	
      "patientFullName":"Nadher",
	  "patientAdress": "Nabeul 8080" ,
	  "patientCountry":"TUNISIA",
	  "patientBirthdate":"1990-01-01",
	  "covidTestResult":"POSITIVE"
  }

```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Number` | **Required**. Id of test to fetch |

#### Delete Test

```http
  POST api/covid-cases/delete/{id}
  Application Type JSON 
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Number` | **Required**. Id of test to fetch |

#### Get report of the total number of cases per day (More 3 contry)
```http
  GET /api/covid-cases/day
```

#### Get report of the total number of cases per mouth (More 3 contry)
```http
  GET /api/covid-cases/mouth
```


#### Get report of the total number of cases per year (More 3 contry)
```http
  GET /api/covid-cases/year
```


### Vaccin 

#### Get all vaccin

```http
  GET /api/covid-vaccination
```
#### Add new vaccin

```http
  POST api/covid-vaccination/create
  { 
	"patientFullName":"rawdha",
	"patientAdress": "Nabeul 8080" ,
	"patientCountry":"Tunisia",
	"patientBirthdate":"1995-01-01" 
  }
```
NB : If the patient does not exist, we create a new patient
#### Update Vaccin

```http
  POST api/covid-vaccination/update/{id}
  Application Type JSON 
  { 
	"patientFullName":"rawdha",
	"patientAdress": "Nabeul 8080" ,
	"patientCountry":"Tunisia",
	"patientBirthdate":"1990-01-01" 
    }

```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Number` | **Required**. Id of test to fetch |

#### Delete vaccin

```http
  POST api/covid-vaccination/delete/{id}
  Application Type JSON 
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Number` | **Required**. Id of test to fetch |

## Running Tests

To run tests, run at project startup

```bash
  npm run test
```


## Author

- [@covid19](https://github.com/zhiouaNadher/covid-19-tracker)

