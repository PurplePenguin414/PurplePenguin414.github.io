n = int(input())
requests = {}

for _ in range(n):
    data = input().split()
    student = " ".join(data[:-1])
    course = data[-1]
    
    if course not in requests:
        requests[course] = set()
    
    requests[course].add(student)

for course in sorted(requests):
    print(course, len(requests[course]))
