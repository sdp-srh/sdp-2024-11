

# creates a list of persons
def create_list():
    list = [
        "Donald",
        "Daisy",
        "Micky",
        "Dagobert",
        1
    ]
    return list


print('Hello World')
persons = create_list()
print(persons)
for person in persons:
    if person == 'Dagobert':
        print('Dagobert is part of the list')
    else:
        print('someone else')
