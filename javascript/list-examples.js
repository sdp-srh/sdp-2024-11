const getPersons = () => {
    const list = []
    list.push({name:'Donald', age:'45'})
    list.push({name:'Micky', age:'20'})
    list.push({name:'Dagobert', age:'80'})
    list.push({name:'Tick', age:'10'})
    return list
}

const run = () => {
    const persons = getPersons()

    const youngPersons  = persons.filter(person => person.age < 40)
    //console.log("young persons", youngPersons)
    console.log('young persons', youngPersons )

    const isSomeOneYoungerThan20  = persons.some(person => person.age <20)
    console.log('younger than 20', isSomeOneYoungerThan20)

    const onlyAges = persons.map(p => p.age)
    console.log('ages', onlyAges)
}

run()