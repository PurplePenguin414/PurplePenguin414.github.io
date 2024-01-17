def calculate_abpm(b, p):
    min_abpm = (60 * (b - 1)) / p
    bpm = (60 * b) / p
    max_abpm = (60 * (b + 1)) / p
    return min_abpm, bpm, max_abpm

def main():
    N = int(input())  # Number of cases

    for _ in range(N):
        b, p = map(float, input().split())
        min_abpm, bpm, max_abpm = calculate_abpm(b, p)
        print(f"{min_abpm:.4f} {bpm:.4f} {max_abpm:.4f}")

if __name__ == "__main__":
    main()
