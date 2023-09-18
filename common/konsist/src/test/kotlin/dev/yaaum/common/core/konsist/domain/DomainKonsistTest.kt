package dev.yaaum.common.core.konsist.domain

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withAllParentsOf
import com.lemonappdev.konsist.api.verify.assert
import dev.yaaum.domain.core.model.BaseDomainModel
import org.junit.Test

class DomainKonsistTest {

    @Test
    fun `all domain models has to be named with a DomainModel suffix`() {
        Konsist
            .scopeFromProject()
            .classes()
            .withAllParentsOf(BaseDomainModel::class)
            .assert {
                it.name.endsWith("DomainModel")
            }
    }
}
