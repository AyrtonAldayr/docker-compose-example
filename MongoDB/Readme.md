Conectarse a MongoDB
You can connect to MongoDB using the MongoDB command line (`mongo`) or a graphical tool like MongoDB Compass.

Using the MongoDB command line:
1. Open a terminal.
2. Run the following command to connect to MongoDB in the container:
    ```
    docker exec -it MONGO_PRUEBAS mongo -u root -p root --authenticationDatabase admin
    ```
    This command will connect you to the MongoDB instance in the `MONGO_PRUEBAS` container using the admin credentials (`root/root`).

Using MongoDB Compass:
1. Open MongoDB Compass.
2. On the connection screen, enter the following connection URI:
    ```
    mongodb://root:root@localhost:27018
    ```
3. Click "Connect".

Connecting to Mongo Express:
Mongo Express is a web interface for MongoDB. You can access it from your web browser.

1. Open your web browser.
2. Navigate to the following URL:
    ```
    http://localhost:8082
    ```
3. Enter the admin credentials (`root/root`) if prompted.
    This will allow you to manage your MongoDB database through a graphical interface.

Summary:
- To connect to MongoDB from the command line, use the command:
  ```
  docker exec -it MONGO_PRUEBAS mongo -u root -p root --authenticationDatabase admin
  ```
- To connect to MongoDB from MongoDB Compass, use the URI:
  ```
  mongodb://root:root@localhost:27018
  ```
- To access Mongo Express, navigate to http://localhost:8082 in your web browser.
Now you should be ready to interact with your MongoDB database!