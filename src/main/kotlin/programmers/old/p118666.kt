package programmers
// 성격 유형 검사하기
// 성격 지표별 유형을 검사. 검사지 문항이 반대로 책정될 수도 있음 (어떤 문항은 비동의2 > 어피치 2점, 다른 문항은 비동의2 > 레오 2점)
// 검사 결과는 모든 질문의 성격 유형 점수의 합 중 각 지표에서 더 높은 점수를 받ㄷ은 것.
// 하나의 지표에서 성격 유형이 같다면 사전순

// survey : 성격 유형 및 동의 비동의 순서 [비동의, 동의] 순서
class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        var map: MutableMap<Char, Int> = mutableMapOf(
                                        'R' to 0, 'C' to 0, 'J' to 0, 'A' to 0,
                                        'T' to 0, 'F' to 0, 'M' to 0, 'N' to 0,
                                        )

        for (n in survey.indices) {
            if (map[survey[n][0]] == null) map[survey[n][0]] = 0
            if (map[survey[n][1]] == null) map[survey[n][1]] = 0

            when(choices[n]){
                1 -> map[survey[n][0]] = map[survey[n][0]]!! + 3
                2 -> map[survey[n][0]] = map[survey[n][0]]!! + 2
                3 -> map[survey[n][0]] = map[survey[n][0]]!! + 1
                4 -> map[survey[n][0]] = map[survey[n][0]]!! + 0
                5 -> map[survey[n][1]] = map[survey[n][1]]!! + 1
                6 -> map[survey[n][1]] = map[survey[n][1]]!! + 2
                7 -> map[survey[n][1]] = map[survey[n][1]]!! + 3
            }

        }

        answer += if(map['R']!! >= map['T']!!) 'R' else 'T'
        answer += if(map['C']!! >= map['F']!!) 'C' else 'F'
        answer += if(map['J']!! >= map['M']!!) 'J' else 'M'
        answer += if(map['A']!! >= map['N']!!) 'A' else 'N'

        return answer
    }
}