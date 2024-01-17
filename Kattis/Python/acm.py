log = []
while True:
    entry = input().split()
    if entry[0] == '-1':
        break
    log.append(entry)

solved_problems = set()
time_score = 0
penalty = 0

for entry in log:
    minutes, problem, result = int(entry[0]), entry[1], entry[2]
    if result == 'right' and problem not in solved_problems:
        solved_problems.add(problem)
        time_score += minutes

num_solved_problems = len(solved_problems)
for entry in log:
    minutes, problem, result = int(entry[0]), entry[1], entry[2]
    if result == 'wrong'and problem in solved_problems:
            penalty += 20
time_score += penalty
total_time_measure = time_score

print(num_solved_problems, total_time_measure)
