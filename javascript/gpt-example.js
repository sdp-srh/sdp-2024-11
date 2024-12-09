const rollDiceAndSum = () => {
    let sum = 0;
    const results = [];
  
    for(let i = 0; i < 10; i++) {
      // Generate a random number between 1 (inclusive) and 6 (inclusive)
      let roll = Math.floor(Math.random() * 6) + 1;
      sum += roll;
      
      results.push({
        'Roll Number': i + 1,
        'Dice Value': roll,
      });
    }
  
    // Add the sum to the results
    results.push({
      'Roll Number': 'Sum',
      'Dice Value': sum,
    });
  
    // Print the table
    console.log(results);
  
    // Return the sum
    return sum;
  }
  
  rollDiceAndSum();
  