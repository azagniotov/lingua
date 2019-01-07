/*
 * Copyright 2018-2019 Peter M. Stahl pemistahl@googlemail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.pemistahl.lingua.report

import com.github.pemistahl.lingua.model.Language
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource

abstract class AbstractArabicDetectionAccuracyReport(
    implementationToUse: LanguageDetectorImplementation
) : AbstractLanguageDetectionAccuracyReport(Language.ARABIC, implementationToUse) {

    @ParameterizedTest
    @CsvFileSource(resources = ["/language-testdata/single-words/ar.txt"], delimiter = CSV_FILE_DELIMITER, encoding = CSV_FILE_ENCODING)
    @DisplayName("single word detection")
    override fun `assert that single words are identified correctly`(singleWord: String) {
        computeSingleWordStatistics(singleWord)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/language-testdata/word-pairs/ar.txt"], delimiter = CSV_FILE_DELIMITER, encoding = CSV_FILE_ENCODING)
    @DisplayName("word pair detection")
    override fun `assert that word pairs are identified correctly`(wordPair: String) {
        computeWordPairStatistics(wordPair)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/language-testdata/sentences/ar.txt"], delimiter = CSV_FILE_DELIMITER, encoding = CSV_FILE_ENCODING)
    @DisplayName("sentence detection")
    override fun `assert that entire sentences are identified correctly`(sentence: String) {
        computeSentenceStatistics(sentence)
    }
}
