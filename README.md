# SheruProjectRepo
# Submitted by Manan Batheja, BITS Pilani, 2017B2A40514P for the placement process of [SheruTezz](https://sheru.se/), ***Chalo Full Power***

Please note, IOTProject has the React Web App, and SheruData has the TCP client-server architecture.
## Steps to run the project
- Step 1: Install Java 1.8 and the corresponding JDK and JRE versions. Download
eclipse (or any IDE)
- Step 2: Download and import the following ```jar files - org.json.jar,```
```json-simple-1.1.jar, javax.ws.rs.jar ```
- Step 3: Open the ```serverClient``` package and run the ```server.java``` class. When this
server is up, run the ```client.java``` class. Now the client is able to share the IoT data
with server.
- Step 4: Run the ```SheruDataApplication.java``` class present in
```com.manan.sheruData``` package which will prepare the end point
```localhost:8080/sherudata/upload``` to receive requests from the front-end
of the web page.
- Step 5: Install ```node``` and ```react```, and then run the npm install in the root directory.
- Step 6: Run ```npm start```. The website should be live

### Possible additions
 - Addition of alerts to the front-end in case the battery level goes less than 20% or the battery starts discharging (the value of current becomes negative) or the pack voltage shoots across 100 mV.
 - Currently, no database is being used. For permanenent storage, some database solution can be leveraged.
 - The ```JSON``` data that has been scraped from the URI should be checked whether it is fresh or stale.
 - The UI of the web app can be improved by leveraging ```CSS```
