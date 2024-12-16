

def is_prime_number(x):
    if x > 1:
        for i in range(2, x):
            if (x % i) == 0:
                return False
        return True
    else:
        return False

if __name__ == '__main__':
    lower = 900
    upper = 1000

    print("Prime numbers between", lower, "and", upper, "are:")

    for num in range(lower, upper + 1):
        # all prime numbers are greater than 1
        if num > 1:
            if (is_prime_number(num)):
                print(num)
