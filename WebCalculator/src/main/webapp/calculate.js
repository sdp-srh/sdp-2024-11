
const calculate = async () => {
	console.log('we calculate now')
	const v1 =document.getElementById('val1').value
	const v2 =document.getElementById('val2').value
	console.log(v1,v2)
	const response = await fetch(`/WebCalculator/multiply?a=${v1}&b=${v2}`)
	const data = await response.text();
	document.getElementById('result').value = data
}