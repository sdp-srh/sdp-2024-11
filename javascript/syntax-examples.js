const arrowFunction = (parameter) => {
    console.log(parameter)
}

function functionKeyword(parameter) {
    console.log(parameter)
}

const myObject = {
    value: 'xyz',
    objectFunction :function (parameter) { console.log(parameter)}
}

class MyClass {
    classFunction(parameter) {
        console.log(parameter)
    }
}

const run = () => {
    arrowFunction('arrow')
    functionKeyword('keyword')
    myObject.objectFunction('object')
    const objOfMyClass = new MyClass()
    objOfMyClass.classFunction('class')
}

run()