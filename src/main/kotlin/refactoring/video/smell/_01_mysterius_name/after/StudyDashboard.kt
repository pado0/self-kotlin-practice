package refactoring.video.smell._01_mysterius_name.after

import org.kohsuke.github.GitHub

class StudyDashboard {

    val reviewrs = hashSetOf<String>()
    val reviews = hashSetOf<String>()

    fun loadReviews() {

        val gitHub = GitHub.connect()
        val repository = gitHub.getRepository("whiteship/live-study")
        val issue = repository.getIssue(30)

        val reviews = issue.comments
        reviews.forEach {
            reviewrs.add(it.userName)
            reviewrs.add(it.body)
        }
    }
}

fun main() {

    val studyDashboard: StudyDashboard = StudyDashboard()
    studyDashboard.loadReviews()

    studyDashboard.reviewrs.forEach{ println(it) }
    studyDashboard.reviews.forEach{ println(it) }

}