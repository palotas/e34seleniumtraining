Source Code: 

https://github.com/digisic/Digital-Bank

https://digisic.github.io/Digital-Bank/

# Deployment
* clone repo 
* go to docker-compose directory 
* make tmp directory 
* copy docker-compose-mysql.yml to tmp directory
* in tmp directory rename docker-compose-mysql.yml to docker-compose.yml
* run docker-compose up 
* app is starting...takes a few minutes

* to stop all running containers run 
```
stop all containers:
docker kill $(docker ps -q)

remove all containers
docker rm $(docker ps -a -q)

remove all docker images
docker rmi $(docker images -q)

remove all docker volumes
docker volume ls -qf dangling=true | xargs -r docker volume rm 
```

* UI user / pass: jsmith@demo.io/Demo123!
* API user: admin@demo.io/Demo123!


## EX1
* register new user via UI without page objects
* works only once because user will be already registered 
* delete user with UTIL API call

## EX2
* requires EX1 to be run first (-> dependency)
* register user that already exists 
* check error message 

--> discuss how this can be reproducible test (e.g. create user via API before running test)
* create user with API call 
* run test 
* delete user with API 

(--> still have problem that test cannot be run in parallel) 

## EX3
- create page objects for registration testcases
- create and delete user via API 

## EX4
- create checking account via UI and deposit 5K 
- reuse the account from previous test, deduct 1K and check balance
- chain the 2 tests via dependency -> show that if something goes wrong in test1, then test2 is affected. 

## EX5 
- create user, account and deposit via API 
- test only that deduction works and check balance 
 
 