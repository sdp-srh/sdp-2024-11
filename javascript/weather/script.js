
const loadWeather = async () => {
    const url = 'https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m'
    const response = await fetch(url)
    const results = await response.json()
    console.log(results)
    displayWeather(results)

}
const displayWeather = (data) => {
    let html = ''
        html += `<h1>Temperature ${data.current.temperature_2m}</h1>` +'\n'
    console.log(html)
    document.getElementById('search-results').innerHTML = html
}



// install: https://www.npmjs.com/package/http-server
// start: npx http-server

/*
const getAPIKey = () => {
    return '<APIKEY>'
}

const loadNews = async () => {
    const searchTerm = document.getElementById('search-field').value
    console.log(searchTerm)
    const url = 'https://newsapi.org/v2/everything?' +
    `q=${searchTerm}&` +
    'from=2023-12-12&' +
    'sortBy=popularity&' +
    `apiKey=${getAPIKey()}`

    const response = await fetch(url)
    const results = await response.json()
    console.log(results)
    displayNews(results.articles)
}

const displayNews = (articles) => {
    let html = ''
    for (let i = 0; i < articles.length; i++) {
        const article = articles[i]
        html += `<h1><a href="${article.url}">${article.title}</a></h1>` +'\n'
        html += `<p>${article.content}</p>` + '\n'
    }
    console.log(html)
    document.getElementById('search-results').innerHTML = html
}
    */