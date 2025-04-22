from collections import defaultdict

def group_users_by_role(users):
    """Group users by their roles.
    
    Args:
        users: List of dictionaries where each dict represents a user.
        
    Returns:
        Dictionary with roles as keys and lists of names as values.
    """
    role_dict = defaultdict(list)
    for user in users:
        role_dict[user['role']].append(user['name'])
    return dict(role_dict)

# Example usage:
if __name__ == '__main__':
    users = [
        {'id': 1, 'name': 'Alice', 'role': 'admin'},
        {'id': 2, 'name': 'Bob', 'role': 'user'},
        {'id': 3, 'name': 'Charlie', 'role': 'admin'},
        {'id': 4, 'name': 'David', 'role': 'user'}
    ]
    print(group_users_by_role(users))