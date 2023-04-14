# Fortune Service
A Spring Boot Project which provides a random fortune from a list of available fortunes.    
You can also add new fortunes to its fortune database by making POST request on it.

### Following are the mappings available in this REST API.

1. **GET /api/fortunes** to fetch all fortunes available. 
2. If **GET /api/fortunes** is passed a 'random' parameter with boolean value, it will provide a random fortune.
3. **POST /fortunes** to add a new fortune.
  
  Sample Request body ->   
  {
    "content":"Today is your lucky day"
  } 