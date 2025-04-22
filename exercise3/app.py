from flask import Flask, jsonify

app = Flask(__name__)

@app.route('/items/<int:item_id>')
def get_item(item_id):
    return jsonify({
        "item_id": item_id,
        "description": "Sample Item"
    })

if __name__ == '__main__':
    app.run(debug=True)