def advertising_decision(r, e, c):
    if e - c > r:
        return "advertise"
    elif e - c == r:
        return "does not matter"
    else:
        return "do not advertise"

def main():
    n = int(input())  # Number of test cases

    for _ in range(n):
        r, e, c = map(int, input().split())
        decision = advertising_decision(r, e, c)
        print(decision)

if __name__ == "__main__":
    main()
