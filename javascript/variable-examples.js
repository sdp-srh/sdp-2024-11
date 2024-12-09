
const assignments = () => {
    let x = 5
    console.log(typeof x)
    x ="a"
    console.log(typeof x)
    x = [1,2,"hallo",4]
    console.log(typeof x)
}

const compares = () => {
    let x = 5
    let y ="5"
    console.log(x == y)
    console.log(x === y)
}


const add = (x,y) => {
    const result = x + y
    console.log(result)
    return result
}

run = () => {
    
    //console.log("assignment results")
    //assignments()
        
    //console.log("compare results")
    //compares()
    //console.log()
    
    console.log("add results")
    
   
    add(50,2)
    // important, you have to take care that the types fit
   
    add("50",2)
   
    add(50,"2")
   
    add("50","2")
   
}


// calls our run function
run()