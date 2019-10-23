package rewards

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component
import java.util.*

inline fun <reified T:Any> loggerFor() = LoggerFactory.getLogger(String::class.java);

@Component
class MyImport: ApplicationRunner {
    companion object {

        private val LOG = loggerFor<MyImport>()

    }

    @Autowired
    private val jdbcTemplate: JdbcTemplate? = null

    override fun run(args: ApplicationArguments?) {

        val query = "SELECT count(1) FROM T_ACCOUNT"
        val res = jdbcTemplate!!.queryForObject(query, Long::class.java)
        LOG.info("Hello, there are $res accounts")
    }
}

@SpringBootApplication
class JdbcBootApplication

fun main(args: Array<String>) {
    runApplication<JdbcBootApplication>(*args)
}