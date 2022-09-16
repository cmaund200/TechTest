# Information Regarding of Design

Working to a CRUD standard, with Repository and Entity/Model Class.
Structure was outlined with possible Inheritance from Reading Class for Separate Readings

- Readings
  - Gas
  - Electric

Not Implemented:
  Separate Readings: Structure was in place to complete a list of Gas/Electric Readings but was unable to 
  design a way to be able to save this to a database.
  Full Structure of a table - Created a simple post to set up and retrieve the information

  {
    "accountId": 1,
    "id": 22,
    "meterId": 13021,
    "reading": 12330,
    "date": null
  }


Future Work:
 - Better Structure in presenting on how to pull data for Readings, either from another table with readings as a join
  or if there is a better way to store the Data in a DB. 
 - Refactor a few of the classes to be more cleaner. While it was best possible solution, I believe it can be more refined under the
  Reading Classes/Interface.
 - Security - Would make more secure to have secure API connectivity, when getting an account number to make sure only 
  the correct person able to pull the data.
 - Testings - Better testing of all use cases - only able to test 2, which one doesn't work completely, but this may
  be due to the structure not be full completed.
 - 
  