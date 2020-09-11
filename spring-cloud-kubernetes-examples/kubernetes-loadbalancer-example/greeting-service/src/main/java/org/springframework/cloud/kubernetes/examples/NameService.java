/*
 * Copyright 2020-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.kubernetes.examples;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service invoking name-service via REST and guarded by Hystrix.
 *
 * @author Gytis Trikleris
 * @author Olga Maciaszek-Sharma
 */
@Service
public class NameService {

	private final RestTemplate restTemplate;

	public NameService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String getName(int delay) {
		return this.restTemplate.getForObject(
				String.format("http://name-service/name?delay=%d", delay), String.class);
	}

}
