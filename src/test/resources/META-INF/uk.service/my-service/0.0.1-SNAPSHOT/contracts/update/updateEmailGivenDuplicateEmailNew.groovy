package contracts.update

org.springframework.cloud.contract.spec.Contract.make {
    request {
        name('update email given unavailable duplicate email')
        method 'PUT'
        url '/my-service/api/2/root/email'
        headers {
             contentType('application/json')
        }
        body('{"email": "duplicate-email@test.com"}')
    }
    response {
        status 400
        body(
            timestamp: $(consumer("2018-05-01T10:30:00.000+0000"), producer(regex(nonBlank()))),
            status: 400,
            error: "Bad Request",
            errors: [
                    [
                        codes: [
                            "Duplicate"
                        ],
                        objectName: "updateEmail",
                        field: "email",
                        bindingFailure: false,
                        code: "Duplicate"
                    ]
            ],
            message: "Validation failed for object='updateEmail'. Error count: 1",
            path: "/my-service/api/2/root/email"
        )
    }
}
