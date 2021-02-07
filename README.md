# ECommerce
Basic implementation of E-commerce app

Steps to run the application:
1. Create a common docker network by running the command `docker network create -d bridge my-bridge-network`
2. Start the DB services 
    - run `docker-compose up` in folder `e-commerce-server/docker/db` 
    
3. Start the server
    - run `docker-compose up` in folder  `e-commerce-server/docker/app`
    
4. Start UI
    - run `docker-compose up` in folder `e-commerce-ui/docker`
