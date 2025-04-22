import requests

def fetch_json_from_api(url):
    """Fetch JSON data from a public API.
    
    Args:
        url: URL of the API endpoint.
        
    Returns:
        Dictionary with the JSON response if successful, None otherwise.
    """
    try:
        response = requests.get(url)
        response.raise_for_status()  # Raises an HTTPError for bad responses
        return response.json()
    except (requests.RequestException, ValueError) as e:
        print(f"Error fetching data: {e}")
        return None

# Example usage:
if __name__ == '__main__':
    api_url = 'https://jsonplaceholder.typicode.com/posts/1'
    data = fetch_json_from_api(api_url)
    print(data)