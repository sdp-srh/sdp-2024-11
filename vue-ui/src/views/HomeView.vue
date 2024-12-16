<template>
  <main>
    <h1>Vue Calculator {{ result }}</h1>
    <div class="calculator">
      <input type="number" v-model.number="a" placeholder="Enter first number">

      <select v-model="operation">
        <option value="">Select operation</option>
        <option value="add">Addition</option>
        <option value="subtract">Subtraction</option>
        <option value="multiply">Multiplication</option>
        <option value="divide">Division</option>
      </select>
      <input type="number" v-model.number="b" placeholder="Enter second number">      
      <button @click="calculate">Calculate</button>
      <div class="result">
        <b>Result: {{ result }}</b>
      </div>
    </div>
  </main>
</template>


<script setup>
  import { ref } from 'vue';
  const a = ref(0);
  const b = ref(0);
  const operation = ref('add');
  const result = ref(-1);

  // here we request the backend data
  const calculate = async () => {
    if (operation.value === 'add') result.value = a.value + b.value;
    if (operation.value === 'subtract') result.value = a.value - b.value;
    if (operation.value === 'multiply') result.value = a.value * b.value;
    if (operation.value === 'divide') result.value = a.value / b.value;
  }
</script>
<style scoped>
body {
  font-family: Arial, sans-serif;
  display: flex;
  justify-content: left;
  align-items: center;
  height: 100vh;
  background-color: #f0f0f0;
}

.calculator {
  background: white;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.calculator input,
.calculator select {
  margin: 10px 0;
  padding: 10px;
  width: 100%;
  box-sizing: border-box;
}

.result {
  margin-top: 20px;
  padding: 10px;
  background: #e0e0e0;
  text-align: center;
  border-radius: 8px;
}
</style>
