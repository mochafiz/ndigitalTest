Feature: API Automation for Pet and User data on Petstore

  @Task1
  Scenario: Add new pet
    Given User Add new Pet API with data:
    """
      {
        "category": {
          "id": 0,
          "name": "Pig"
        },
        "name": "Big Pink Pig",
        "photoUrls": [
          "pigImage.png"
        ],
        "tags": [
          {
            "id": 0,
            "name": "Piggie"
          }
        ],
        "status": "available"
      }
    """
    Then Pet response should be:
    """
      {
        "category": {
          "id": 0,
          "name": "Pig"
        },
        "name": "Big Pink Pig",
        "photoUrls": [
          "pigImage.png"
        ],
        "tags": [
          {
            "id": 0,
            "name": "Piggie"
          }
        ],
        "status": "available"
      }
    """

  @Task2
  Scenario: Find Pet by Status
    Given User Find Pet by Status "available"
    Then User response should be same with schema and status code 200

  @Task3
  Scenario: Update user data
    Given User Update data with username "hafiz"
    """
      {
        "username": "hafiz",
        "firstName": "hafiz",
        "lastName": "muhammad",
        "email": "mochafiz@gmail.com",
        "password": "string",
        "phone": "0816908521",
        "userStatus": 1
      }
    """
    Then User status code should be 200
    When User Get Data with username "hafiz"
    Then User response should be:
    """
    {
      "username": "hafiz",
      "firstName": "hafiz",
      "lastName": "muhammad",
      "email": "mochafiz@gmail.com",
      "password": "string",
      "phone": "0816908521",
      "userStatus": 1
    }
    """

  @Task4
  Scenario: Show school value on json
    Given User read school json as object
    Then Print the student value