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
