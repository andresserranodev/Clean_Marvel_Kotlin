package com.puzzlebench.cmk.domain.usecase

import com.puzzlebench.cmk.domain.model.MarvelCard
import com.puzzlebench.cmk.domain.service.CreatorsService
import io.reactivex.Single

class GetCreatorsServiceUseCase constructor(val service: CreatorsService) : BaseServiceUseCase {

    override fun invoke(): Single<List<MarvelCard>> = service.getCreators()

}