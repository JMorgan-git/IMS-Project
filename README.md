Coverage: 72.9%
# IMS Starter_project

This application has the capacity to create,display,update and delete; customers, items and orders in a database table.
Customers and the features that went with customers was already provided, I have added items and orders allong with the features that go with them.
Due to some bugs i was unable to resolve, one feature was cut, being able to read the items attached to an order.
Because of the feature being cut the current working version of the project involves being able to create, read, update and delete customers, items and orders. without the ablitiy to view items that were added to the orders.

## Testing


### Controller Tests Mockito

The controller tests use mockito to send variables and values into each test, these values corospond with what would be user inputs if you were to run this application, for example;
in the create method(this metod is used in all three controllers) the test gives the create method a first name and a second name, these values will be sent through the DAO version of said controller, expecting a return value that corrosponds with said values. meaning you send through F_Name "barry", L_Name "Scott", the test expects "barry","scott" to return.

the other test methods react similarly;
read method - the test expects to return the List you send in (Long, String, String)

update method - the test expects to return the object(Long, String, String) 

delete method - expects nothing

### DAO Test Methods
These tests act similarly to controller tests, however they connect to a mock SQL database and expects to return values retrieved from SQL
these tests are the bulk of the applications functionality,
the methods they test are essentially where all the connections to the database happens and where all the calculations are completed.

in each method the test tests if there is a connection and returns the values retrieved from said connection.
create returns the item you create
read returns the items in the database
update returns the item you updates
delete returns 0

### Domain Test Methods
Since these classes are at the bottom, with purely getters, setters, tostrings and hashcodes inside them these tests are the most simple, it simply just makes sure it works, since there is nothing calculated or executed further than what it is. 

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

* **Jesse Morgan** - *Updated Version of the Initial work* - [jessemorgan](https://github.com/JMorgan-git/IMS-Project) 
* 
## Jira

* https://jesse-morgan.atlassian.net/jira/software/projects/IMS/boards/1/backlog

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Some of the preexisting code from the first version of this app was used as framework and inspiration in a few places
* Pawel Stypulkowski helped aim me in the right direction with a few fixes of errors
