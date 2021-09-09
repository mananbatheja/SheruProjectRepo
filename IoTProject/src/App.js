import axios from "axios";
import React, { useEffect, useState } from "react";

function App() {
  const [showData, setShowData] = useState(true);
  const [data, setData] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/sherudata/upload")
      .then((response) => {
        setData(response.data);
        console.log(JSON.parse(response.data));
      })
      // .then(console.log(data))
      .catch((err) => {
        alert(`Could'nt Fetch Data. 
      Error - ${err}`);
      });
  }, []);

  const handleButtonCLick = () => {
    setShowData(!showData);
    if (showData) document.getElementById("123").innerHTML = "Connect Here";
    else document.getElementById("123").innerHTML = "Disconnect Here";
  };

  return (
    <div className="App">
      <button id="123" onClick={handleButtonCLick}>
        Disconnect Here
      </button>
      <br></br>
      {data}

      {/* {showData &&
        data.map((data1, key) => {
          return (
            <Line key={key} data={data1} />
            // <div key={key}>
            //   {JSON.stringify(data1)}
            // </div>
          );
        })} */}
    </div>
  );
}

export default App;
