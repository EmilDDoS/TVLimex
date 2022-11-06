package com.example.tvlimex.di

import androidx.lifecycle.ViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
        DataModule::class,
        DomainModule::class,
        ApplicationModule::class
    ]
)

interface AppComponent {
    val mapModels: Map<Class<*>, ViewModel>
}