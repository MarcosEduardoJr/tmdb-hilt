package com.marcosedu.movies.di

import com.marcosedu.movies.data.DiscoveryRepository
import com.marcosedu.movies.data.DiscoveryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsDiscoveryRepository(
        discoveryRepositoryImpl: DiscoveryRepositoryImpl
    ): DiscoveryRepository
}