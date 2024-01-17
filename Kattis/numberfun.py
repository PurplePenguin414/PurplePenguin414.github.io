def is_possible(a, b, c):
    # Check if c can be obtained using addition, subtraction, multiplication, or division
    if a + b == c or a - b == c or b - a == c or a * b == c:
        return "Possible"
    elif a != 0 and b != 0:
        if a / b == c or b / a == c:
            return "Possible"
    
    return "Impossible"

def main():
    N = int(input())  # Number of test cases

    for _ in range(N):
        a, b, c = map(int, input().split())
        result = is_possible(a, b, c)
        print(result)

if __name__ == "__main__":
    main()
