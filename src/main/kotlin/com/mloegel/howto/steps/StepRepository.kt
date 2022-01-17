package com.mloegel.howto.steps

import org.springframework.data.repository.CrudRepository

interface StepRepository: CrudRepository<Step, String> {
}