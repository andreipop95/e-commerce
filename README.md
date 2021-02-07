# ECommerce
Basic implementation of E-commerce app


Steps to run the dockerized application
1. Create a common docker network by running the command `docker network create -d bridge db_application`
2. Start the DB services 
    - run `docker-compose up` in folder `e-commerce-server/docker/db` 
    
3. Start the server - run the following commands in the folder `e-commerce-server/docker/app`
    - `docker-compose build`
    - `docker-compose up`
    
4. Start UI - for some reason the dockerized version doesn't work - didn't have enough time to debug it.
In the folder `e-commerce-ui`, run the following commands
    - `npm install`
    - `ng serve`
    
    The application will start on http://localhost:4200/
    
    
When the application starts, there's no data in the DB. Some articles need to be added first, before any operation can be performed.
    
