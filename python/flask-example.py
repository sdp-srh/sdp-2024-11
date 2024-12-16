from flask import Flask

app = Flask(__name__)

@app.route("/")
def hello():
    return "<h1>Hello, SDP Course!</h1>"

@app.route("/bye")
def bye():
    return "Goodbye, SDP Course!"

if __name__ == "__main__":
    app.run()


