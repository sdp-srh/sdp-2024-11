import { useState } from 'react';
import './App.css';

function App() {
  // State to manage input values and the result
  const [data, setData] = useState({ a: '', b: '', result: 0 });

  // Handle input changes
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setData({ ...data, [name]: value });
  };

  // Calculate the sum of a and b
  const calculateSum = () => {
    const sum = parseFloat(data.a) + parseFloat(data.b);
    setData({ ...data, result: isNaN(sum) ? 0 : sum });
  };

  return (
    <div className="App">
      <header className="App-header">
        <h1>Simple Calculator</h1>

        {/* Input fields for a and b */}
        <div>
          <input
            type="number"
            name="a"
            placeholder="Enter value for a"
            value={data.a}
            onChange={handleInputChange}
          />
          <input
            type="number"
            name="b"
            placeholder="Enter value for b"
            value={data.b}
            onChange={handleInputChange}
          />
        </div>

        {/* Button to trigger calculation */}
        <button onClick={calculateSum}>Calculate Sum</button>
        {/* Display result */}
        <h1>Result: {data.result}</h1>
      </header>
    </div>
  );
}

export default App;