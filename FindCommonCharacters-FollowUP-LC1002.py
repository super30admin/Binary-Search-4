def commonChars(words):
    d1 = {}
    ans = []
    for c in words[0]:
        if c in d1: d1[c] += 1
        else: d1[c] = 1
    for word in words[1:]:
        temp = {}
        for c in word:
            if c in d1: 
                if c in temp: temp[c] += 1
                else: temp[c] = 1
                if d1[c] == 1: d1.pop(c)
                else: d1[c] -= 1
        d1 = temp
    for k in d1:
        ans += [k]*d1[k]
    return ans

print(commonChars(["bella","label","roller"]))
print(commonChars(["cool","lock","cook"]))