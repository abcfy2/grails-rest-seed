package top.dteam.earth.backend

import grails.databinding.converters.ValueConverter
import grails.gorm.services.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier

import java.time.LocalDateTime
import java.time.OffsetDateTime

@Service(Example)
abstract class ExampleService {

    @Autowired
    @Qualifier('grails.databinding.converters.ValueConverter(localDateTimeValueConverter)')
    ValueConverter localDateTimeValueConverter

    @Autowired
    @Qualifier('grails.databinding.converters.ValueConverter(offsetDateTimeValueConverter)')
    ValueConverter offsetDateTimeValueConverter

    abstract Example get(Serializable id)

    abstract Long count()

    abstract Example save(Example user)

    abstract List<Example> list(Map args)

    LocalDateTime string2LocalDateTime(String startTime) {
        localDateTimeValueConverter.convert(startTime)
    }

    OffsetDateTime string2OffsetDateTime(String startTime) {
        offsetDateTimeValueConverter.convert(startTime)
    }

}
