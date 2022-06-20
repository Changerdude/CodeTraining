package com.example.firstdi

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideBooksRepo(): BooksRepo{
        return BooksRepoImplementer()
    }
}