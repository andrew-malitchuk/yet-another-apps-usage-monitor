package dev.yaaum.common.core.konsist.data

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withAllParentsOf
import com.lemonappdev.konsist.api.verify.assert
import dev.yaaum.data.repository.core.model.base.BaseRepoModel
import org.junit.Test

class DataKonsistTest {

    @Test
    fun `all data models which are located in repo has to be named with a RepoModel suffix`() {
        Konsist
            .scopeFromProject()
            .classes()
            .withAllParentsOf(BaseRepoModel::class)
            .assert {
                it.name.endsWith("RepoModel")
            }
    }
}
