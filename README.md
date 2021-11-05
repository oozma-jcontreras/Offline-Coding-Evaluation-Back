# Offline Coding Evaluation
## Products RESTful API

## Description
This project was developed to apply for a job as Full Stack Developer in Falabella

## Architectural and Technological decisions

I decided to use the following decisions:
- DB Access: JPA: It's a simple a fast way to access to relational DB
- Jacoco: To generate test coverage
- Mapstruct: For mapping object easily

#### Architecture

This project is a simple CRUD application developed only to maintain products.

The project is a microservice that was separated in the following layers:
1. entities: layer with jpa entities that represents tables en DB
2. dto: simply classes to send and receive data from controller.
3. mapper: classes used to map dto to entities and vice versa
4. service: business logic
5. controller: api rest controller 

## How to build and run the project

### Data Base

This project use SQL Server 2017 to store data. You must create a database call "falabella"
and then, create the following tables or let JPA create them for you.
```
CREATE TABLE [dbo].[product_images](
	[image_id] [int] NOT NULL,
	[image] [varchar](500) NULL,
	[product_sku] [varchar](255) NULL,
	PRIMARY KEY CLUSTERED 
	(
		[image_id] ASC
	)
)
GO

CREATE TABLE [dbo].[products](
	[sku] [varchar](255) NOT NULL,
	[brand] [varchar](50) NULL,
	[name] [varchar](50) NULL,
	[price] [float] NULL,
	[principal_image] [varchar](500) NULL,
	[size] [varchar](255) NULL,
	PRIMARY KEY CLUSTERED 
	(
		[sku] ASC
	)
)
GO

ALTER TABLE [dbo].[product_images]  WITH CHECK ADD  CONSTRAINT [FKdbbr4huse3wpsqvmip735pck0] FOREIGN KEY([product_sku])
REFERENCES [dbo].[products] ([sku])
GO

ALTER TABLE [dbo].[product_images] CHECK CONSTRAINT [FKdbbr4huse3wpsqvmip735pck0]
GO

```

### Java Project
Once the source code is downloaded, open a command line and run the follow command:
```
./gradlew bootRun
```

## Run test

Like the previous step, open a command line ang run the follow command:
```
./gradlew test
```
