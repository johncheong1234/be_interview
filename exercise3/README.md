```markdown
# Exercise3 - Python API and Data Processing Exercises

This repository contains solutions to four Python exercises focusing on Flask API development, data processing, external API interaction, and database ORM concepts.

## Exercise Solutions

### 3.1 Simple API with Flask (`app.py`)
**Task**: Create a basic web API with one endpoint `/items/{item_id}` that returns a JSON response.

**Solution**:
- Implements a Flask application with a single route
- Returns JSON response with the format `{"item_id": <item_id>, "description": "Sample Item"}`

**How to Run**:
1. Install Flask if not already installed:
   ```bash
   pip install flask
   ```
2. Run the application:
   ```bash
   python app.py
   ```
3. Access the endpoint at:
   ```
   [http://127.0.0.1:5000/items/123](http://127.0.0.1:5000/items/123)
   ```
   (Replace `123` with any integer)

### 3.2 Data Processing with Dictionaries/Lists (`data_processing.py`)
**Task**: Process a list of user dictionaries to group names by roles.

**Solution**:
- Uses `defaultdict` for efficient grouping
- Implements `group_users_by_role()` function that takes user list and returns role-based grouping
- Example input/output included in the file

**How to Run**:
```bash
python data_processing.py
```

### 3.3 Interacting with an External API (`external_api.py`)
**Task**: Fetch data from a public JSON API with proper error handling.

**Solution**:
- Implements `fetch_json_from_api()` function with:
    - `requests.get()` for API calls
    - Comprehensive error handling for network issues
    - JSON response parsing
- Uses `jsonplaceholder.typicode.com` as example API

**How to Run**:
1. Install `requests` if not already installed:
   ```bash
   pip install requests
   ```
2. Run the script:
   ```bash
   python external_api.py
   ```

### 3.4 Database Interaction with SQLAlchemy (`models.py`)
**Task**: Demonstrate ORM concepts with SQLAlchemy for a `Product` table.

**Solution**:
- Defines `Product` model with `id`, `name`, and `price` columns
- Implements `get_expensive_products()` function to query products > $100
- Includes in-memory SQLite demonstration with sample data

**How to Run**:
1. Install SQLAlchemy if not already installed:
   ```bash
   pip install sqlalchemy
   ```
2. Run the script:
   ```bash
   python models.py
   ```

## Dependencies
- Python 3.6+
- Flask (for Exercise 3.1)
- requests (for Exercise 3.3)
- SQLAlchemy (for Exercise 3.4)

Install all dependencies with:
```bash
pip install flask requests sqlalchemy
```

## Testing the Solutions
Each file includes example usage in its `if __name__ == '__main__':` block that demonstrates the functionality:

- `app.py`: Run the Flask server and visit the endpoint
- `data_processing.py`: Processes sample user data
- `external_api.py`: Fetches from JSONPlaceholder API
- `models.py`: Creates in-memory database with sample products

## Key Concepts Demonstrated
- Flask API setup and routing
- Dictionary/list manipulation with `defaultdict`
- External API interaction with error handling
- ORM modeling and querying with SQLAlchemy
```